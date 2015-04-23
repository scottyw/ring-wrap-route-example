# ring-wrap-routes-example

A quick example of Compojure's wrap-routes function which can lead to the application of Ring middlewares in an unexpected order.

## Usage

The example is self-documenting. Run with:

    lein run
    
## Results
```
$ lein run
The middlewares are applied in the obvious order when thread-first is used
 - In top-level-middleware
 - In handler1-middleware
 - In handler1
wrap-routes applied only to the outer middleware causes it to be inserted inside the handler-specific middleware
 - In handler1-middleware
 - In top-level-middleware
 - In handler1
wrap-routes applied to both middlewares doesn't give thread-first semantics either
 - In handler1-middleware
 - In top-level-middleware
 - In handler1
wrap-routes applied only to the handler-specific middleware is the same as thread-first
 - In top-level-middleware
 - In handler1-middleware
 - In handler1
```

## License

Copyright © 2015 Scott Walker

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
