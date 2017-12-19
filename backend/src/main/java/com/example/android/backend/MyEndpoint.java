package com.example.android.backend;

/**
 * Created by SSubra27 on 11/18/17.
 */

import com.example.android.javalib.JokeSayer;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(name = "myApi",
      version = "v1",
      namespace = @ApiNamespace(
      ownerDomain="javalib.android.example.com",
      ownerName="javalib.android.example.com",
              packagePath=""))


public class MyEndpoint {
@ApiMethod(name="sayJoke")
    public JokeSayer sayJoke() {
    JokeSayer jokeSayer = new JokeSayer();
    jokeSayer.setJoke();
    jokeSayer.getJoke();
    return jokeSayer;
}

}
