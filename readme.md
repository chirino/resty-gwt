![RestyGWT](http://restygwt.fusesource.org/images/restygwt-logo.png)
==============

Description
-----------

RestyGWT is a GWT generator for REST services and JSON encoded data transfer objects.

Features
--------

* Generates Async Restful JSON based service proxies
* Java Object to JSON encoding/decoding
* Easy to use REST API


REST Services
-------------

RestyGWT Rest Services allow you to define an asynchronous Service interfaces which are 
implemented by a RestyGWT generator.  See the following listing for an example:

{pygmentize::java}
import javax.ws.rs.POST;
...
public interface PizzaService extends RestService {
    @POST
    public void order(PizzaOrder request, 
                      MethodCallback<OrderConfirmation> callback);
}
{pygmentize}

JAX-RS annotations are used to control how the methods interface map to HTTP requests.  The 
interface methods MUST return void.  Each method must declare at least one callback argument.  
Methods can optionally declare one method argument before the callback to pass via the request
body.  Java beans are automatically encoded and decoded as JSON objects.    

REST API
--------

The RestyGWT REST API is handy when you don't want to go through the trouble of creating 
service interfaces.

The following example, will post  a JSON request and receive a JSON response. 
It will set the HTTP `Accept` and `Content-Type` and `X-HTTP-Method-Override` header t
o the expected values.  It will also expect a HTTP 200 response code, otherwise it will 
consider request the request a failure.

{pygmentize::java}
Resource resource = new Resource( GWT.getModuleBaseURL() + "pizza-service");

JSONValue request = ...

resource.post().json(request).send(new JsonCallback() {
    public void onSuccess(Method method, JSONValue response) {
        System.out.println(response);
    }
    public void onFailure(Method method, Throwable exception) {
        Window.alert("Error: "+exception);
    }
});
{pygmentize}

All the standard HTTP methods are supported: 

* `resource.head()`
* `resource.get()`
* `resource.put()`
* `resource.post()`
* `resource.delete()`

The above methods allow you to fully configure the request headers and options such as 
basic authentications credentials.

In addition to the standard HTTP methods, it also supports a `resouce.jsonp()` method which
gets the remote resources via a JSONP request which allows you to do cross domain requests to
external websites like yahoo and google.

Getting started
---------------

For more details, checkout the [user guide](http://restygwt.fusesource.org/documentation/index.html)

Event Handling
--------------

References
..........

* http://stackoverflow.com/questions/2951621/gwt-custom-events/2967359#2967359

