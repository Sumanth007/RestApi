package com.sumanth.RestApi.run;

/**
 * Copyright (c) 2024 Your Company. All rights reserved.
 * This file is licensed under the MIT License.
 * See the LICENSE file for details.
 */
public class RunNotFoundException extends RuntimeException{
    public RunNotFoundException(){
        super("Run Not Found");
    }
}
