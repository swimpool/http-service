# HTTP Service

An Android Service application which allows Chameleon Widgets to perform HTTP requests without encountering any cross-domain issues.

## Usage

### Checking for the service
```js
chameleon.componentExists({
  name: 'com.widgetgecko.android.httpservice.HttpWidgetService',
  package: 'com.widgetgecko.android.httpservice'
})
```
### Installing the service
```js
if (chameleon.allowsNonMarketInstall()) {
  chameleon.install({
    url: 'http://widgetgecko.com/android/httpservice/WidgetGecko-HttpService-0.1.apk'
  });
}
else {
  chameleon.intent({
    action: 'android.intent.action.VIEW',
    data: 'market://com.widgetgecko.android.httpservice'
  });
}
```
### Using the service
```js
chameleon.intent({
  component: {
    name: 'com.widgetgecko.android.httpservice.HttpWidgetService',
    package: 'com.widgetgecko.android.httpservice',
    type: 'chameleonservice'
  },
  data: {
    url: 'http://widgetgecko.com/api/apod/apod.json',
    method: 'GET',
    params: {
      testParam: 'test-value-1'
    }
  },
  result: function (data) {
    if (! data) {
      return;
    }
    var result = chameleon.toJSON(data);
  }
});
```
