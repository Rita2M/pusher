import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("my-first.json")))
        .setDatabaseUrl(dbUrl)
        .build()

    FirebaseApp.initializeApp(options)


    val message = Message.builder()
        .putData("action", "LIKE")
        .putData(
            "content", """{
          "userId": 1,
          "userName": "Maxim",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent()
        )
        .setToken(token)
        .build()
    val message2 = Message.builder()
        .putData("action", "POST")
        .putData(
            "content", """{
            "userId": 2,
            "postAuthor": "Tom",
            "postId": 1,
            "textPost": "Я не люблю себя, когда я трушу, Досадно мне. когда невинных бьют, Я не люблю, когда мне лезут в душу, Тем более, когда в неё плюют!"
            }""".trimMargin()
        )
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
    FirebaseMessaging.getInstance().send(message2)
}