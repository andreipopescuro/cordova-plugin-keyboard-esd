import UIKit

@objc(Keyboard) class Keyboard: CDVPlugin {
    @objc(show:)
    func show(command: CDVInvokedUrlCommand) {
        DispatchQueue.main.async {
            let keyWindow = UIApplication.shared.windows.filter {$0.isKeyWindow}.first
            keyWindow?.endEditing(false)
        }
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
        self.commandDelegate.send(pluginResult, callbackId: command.callbackId)
    }

    @objc(hide:)
    func hide(command: CDVInvokedUrlCommand) {
        DispatchQueue.main.async {
            let keyWindow = UIApplication.shared.windows.filter {$0.isKeyWindow}.first
            keyWindow?.endEditing(true)
        }
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
        self.commandDelegate.send(pluginResult, callbackId: command.callbackId)
    }
}
