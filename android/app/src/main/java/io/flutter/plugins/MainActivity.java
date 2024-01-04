package io.flutter.plugins;

import android.os.Bundle;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

import com.wiseai.ekyc110.*;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "com.wiseai.ekyc";

    private WiseAiApp wiseAiApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("initialize")) {
                                String token = call.argument("token");
                                String urlEndpoint = call.argument("urlEndpoint");
                                initializeWiseAI(token, urlEndpoint);
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }

    private void initializeWiseAI(String token, String urlEndpoint) {
        wiseAiApp = new WiseAiApp();
        wiseAiApp.init(this, token, urlEndpoint);
        // Other initialization or logic related to WiseAI
    }

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

    }
}
