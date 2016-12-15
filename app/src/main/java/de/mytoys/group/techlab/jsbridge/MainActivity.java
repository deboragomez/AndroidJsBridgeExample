package de.mytoys.group.techlab.jsbridge;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Class that presents the information on the screen.
 *
 * @author Debora Gomez
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //WebView Object
        WebView wv = (WebView) findViewById(R.id.webview);
        //Injects cookie to specify the platform.
        final CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie(".mytoys.de", "App_Type=Android; path=/");
        //Enable Javascript
        wv.getSettings().setJavaScriptEnabled(true);
        //Inject WebAppInterface methods into Web page by having Interface name 'Android'
        wv.addJavascriptInterface(new WebAppInterface(this), "Android");
        //Load URL inside WebView
        wv.loadUrl("file:///android_asset/myPage.html");
    }

    /**
     * Class to be injected in Web page.
     */
    public class WebAppInterface {

        Context context;

        /**
         * Instantiate the interface and set the context
         */
        WebAppInterface(Context c) {
            context = c;
        }

        /**
         * Show Toast Native Message in the Screen.
         *
         * @param toast Toast message.
         */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
        }

        /**
         * Updates the basket (in the future). Right now just shows a popup with the JSON information.
         *
         * @param basketJson Basket JSON info.
         */
        @JavascriptInterface
        public void updateBasket(String basketJson) {
            AlertDialog dialog = new AlertDialog.Builder(context).create();
            dialog.setMessage(basketJson);
            dialog.show();
        }
    }
}
