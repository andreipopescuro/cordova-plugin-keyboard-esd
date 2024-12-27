var exec = require("cordova/exec");

exports.show = function (success, error) {
  exec(success, error, "Keyboard", "show", []);
};

exports.hide = function (success, error) {
  exec(success, error, "Keyboard", "hide", []);
};
