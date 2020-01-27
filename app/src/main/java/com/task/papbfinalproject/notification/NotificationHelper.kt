package com.pertamina.spbucare.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.DEFAULT_VIBRATE
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.task.papbfinalproject.R


class NotificationHelper {

    companion object NotificationApplication {
        private const val CHANNEL_ID = "epl"
        private const val CHANNEL_NAME = "EPL"
        private const val CHANNEL_DESC = "EPL Notification"
        private var countNotif = 0

        fun displayNotification(context: Context, title: String, body: String, image: Int) {
            val summaryId = 0
            val notifyId = (0..40).random()
            countNotif++

            val groupOrder = "com.task.papbfinalproject.event"

            Glide.with(context)
                .asBitmap()
                .load(image)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(title)
                            .setLargeIcon(resource)
                            .setContentText(body)
                            .setDefaults(DEFAULT_VIBRATE)
                            .setAutoCancel(true)
                            .setGroup(groupOrder)
                            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
                            .setPriority(NotificationCompat.PRIORITY_MAX)

                        val summaryNotification = NotificationCompat.Builder(context, CHANNEL_ID)
                            .setContentTitle(title)
                            .setContentText(body)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setStyle(
                                NotificationCompat.InboxStyle()
                                    .setSummaryText("$countNotif Notifikasi")
                            )
                            .setGroup(groupOrder)
                            .setGroupSummary(true)
                            .build()


                        val notifManager = NotificationManagerCompat.from(context)
                        notifManager.notify(notifyId, builder.build())
                        notifManager.notify(summaryId, summaryNotification)

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            val channel =
                                NotificationChannel(
                                    CHANNEL_ID,
                                    CHANNEL_NAME,
                                    NotificationManager.IMPORTANCE_HIGH
                                )
                            channel.description = CHANNEL_DESC
                            channel.setShowBadge(true)
                            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                            val manager = context.getSystemService(NotificationManager::class.java)
                            manager?.createNotificationChannel(channel)
                        }
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        }
    }
}