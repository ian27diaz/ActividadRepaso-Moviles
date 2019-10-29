package ian.meda.abccompany

import android.app.Application
import com.parse.Parse

class abcApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(Parse.Configuration.Builder(this)
            .applicationId("S7UgQLQfFGefiICqEseHlK5Gul5ryYT4vmQHlOTw")
            .clientKey("z6k4Ay9nwrsOxg1KpJIHszcWeVv9s9VdMlatHFOj")
            .server("https://parseapi.back4app.com/")
            .build())
    }
}