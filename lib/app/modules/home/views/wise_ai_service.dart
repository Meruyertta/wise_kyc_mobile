import 'package:flutter/services.dart';

class WiseAIService {
  static const MethodChannel _channel = MethodChannel('com.wiseai.ekyc');

  static Future<void> initialize(String token, String urlEndpoint) async {
    try {
      final res = await _channel.invokeMethod("initialize");
      return res;
    } on PlatformException catch (e) {
      throw 'Failed to initialize WiseAI: ${e.message}';
    }
  }
}
