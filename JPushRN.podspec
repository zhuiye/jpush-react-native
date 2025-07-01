require 'json'
pjson = JSON.parse(File.read('package.json'))

fabric_enabled = ENV['RCT_NEW_ARCH_ENABLED'] == '1'


Pod::Spec.new do |s|

  s.name            = "JPushRN"
  s.version         = pjson["version"]
  s.homepage        = pjson["homepage"]
  s.summary         = pjson["description"]
  s.license         = pjson["license"]
  s.author          = pjson["author"]
  
  s.platforms       = { :ios => "11.0" }
  s.frameworks      = 'UIKit','CFNetwork','CoreFoundation','CoreTelephony','SystemConfiguration','CoreGraphics','Foundation','Security'
  s.source          = { :git => "https://github.com/jpush/jpush-react-native.git", :tag => "#{s.version}" }
  s.source_files    = "ios/**/*.{h,m,mm,swift}"
  s.preserve_paths  = "*.js"
  s.weak_frameworks = 'UserNotifications'
  s.libraries       = 'z','resolv'
  s.vendored_frameworks = "ios/RCTJPushModule/*.xcframework"

  if fabric_enabled
    # Use install_modules_dependencies helper to install the dependencies if React Native version >=0.71.0.
    # See https://github.com/facebook/react-native/blob/febf6b7f33fdb4904669f99d795eba4c0f95d7bf/scripts/cocoapods/new_architecture.rb#L79.
    if respond_to?(:install_modules_dependencies, true)
      install_modules_dependencies(s)
    else
      # just for backward compatibility: if React Native version <= 0.70.x
      s.compiler_flags = "-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1 -Wno-comma -Wno-shorten-64-to-32 -DRCT_NEW_ARCH_ENABLED=1"
      s.pod_target_xcconfig    = {
        "HEADER_SEARCH_PATHS" => "\"$(PODS_ROOT)/boost\"",
        "OTHER_CPLUSPLUSFLAGS" => "-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1",
        "CLANG_CXX_LANGUAGE_STANDARD" => "c++17"
      }

      s.dependency 'React-Core'
      s.dependency "React-Codegen"
      s.dependency "React-RCTFabric"
      s.dependency "RCT-Folly"
      s.dependency "RCTRequired"
      s.dependency "RCTTypeSafety"
      s.dependency "ReactCommon/turbomodule/core"
    end
  else
    s.dependency 'React-Core'
  end
end