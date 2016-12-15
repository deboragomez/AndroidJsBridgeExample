# AndroidJsBridgeExample

This project is just a Proof of Concept about how JavaScript bridge works in an Android project.

## MainActivity

This class loads a local webpage `myPage.html` which is located under the `assets` folder and exposes two JavaScript interfaces `showToast(String)` and `updateBasket(String)`.

## myPage.html

This HTML file just presents two buttons that call the native JS interfaces `Android.updateBasket()` and `Android.showToast()`.

## Further information

Please visit the [Android Developers](https://developer.android.com/guide/webapps/webview.html) site where you can find more examples.