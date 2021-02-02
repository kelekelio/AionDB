package com.grzegorznowakowski.AionDB;

import com.grzegorznowakowski.AionDB.db.object.CallbackMatcher;

import java.util.regex.MatchResult;

/**
 * @author Grzegorz Nowakowski
 */
public class MainCallBack {

    public static void main(String[] args) {

        String test = "그새 [%dic:STR_DIC_MLA116]%을 처치하고 왔나? [%dic:STR_DIC_MLA116]% 보기보단 제법인걸.";

        CallbackMatcher.Callback callback = matchResult -> {
            return matchResult.group(1);
        };

        CallbackMatcher callbackMatcher = new CallbackMatcher("\\[%dic:(?<translation>[a-z_0-9]+)\\]%");
        test = callbackMatcher.replaceMatches(test, callback);

        System.out.println(test);


    }
}
