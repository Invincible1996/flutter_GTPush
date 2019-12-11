#import "FlutterGtpushPlugin.h"
#import <flutter_gtpush/flutter_gtpush-Swift.h>

@implementation FlutterGtpushPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterGtpushPlugin registerWithRegistrar:registrar];
}
@end
