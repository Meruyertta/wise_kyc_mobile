import 'package:flutter/services.dart';

class WiseAIService {
  static const MethodChannel _channel = MethodChannel('com.wiseai.ekyc');

  static Future<void> initialize({required String token, required String urlEndpoint}) async {
    try {
      await _channel.invokeMethod('initialize', {
        'token': token,
        'urlEndpoint': urlEndpoint,
      });
      print('WiseAI Initialized');
    } catch (e) {
      print('Failed to initialize WiseAI: $e');
      throw 'Failed to initialize WiseAI: $e';
    }
  }
}
