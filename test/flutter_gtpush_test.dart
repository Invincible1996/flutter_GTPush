import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_gtpush/flutter_gtpush.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_gtpush');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterGTPush.platformVersion, '42');
  });
}
