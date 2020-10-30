package com.nopcommerce.demo.navigationtiming;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopcommerce.demo.driver.DriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PerfNavigationTiming {
    private Map<String, Object> timings = null;
    private static FileWriter fileWriter;

    private final static File PERF_METRICS_JSON = new File("perfMetrics.json");

    public void writeMetricsToJsonFile(String pageName) throws IOException {
        getAllTiming();

        ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonObject;
        jsonObject = PERF_METRICS_JSON.exists() ? mapper.readValue(PERF_METRICS_JSON, JSONObject.class) : new JSONObject();
        JSONArray entityArray = new JSONArray();
        JSONObject innerJsonObject = new JSONObject();
        innerJsonObject.put("latency", getLatency());
        innerJsonObject.put("tti", getTimeToInteract());
        innerJsonObject.put("ttl", getTimeToLoad());
        innerJsonObject.put("onload", getOnload());
        innerJsonObject.put("total_time", getTotalTime());

        entityArray.add(innerJsonObject);
        jsonObject.put(pageName, entityArray);

        try {
            fileWriter = new FileWriter(PERF_METRICS_JSON);
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void getAllTiming() {
        JavascriptExecutor jsrunner = (JavascriptExecutor) DriverManager.getDriver();
        String javaScriptForPerformance = "var performance = window.performance || window.webkitPerformance ||" +
                " window.mozPerformance || window.msPerformance || {};var timings = performance.timing || {};return timings;";
        timings = (Map<String, Object>) jsrunner.executeScript(javaScriptForPerformance);
    }

    public long getLatency() {
        return getResponseStart() - getNavigationStart();
    }

    public long getTimeToInteract() {
        return getDomInteractive() - getDomLoading();
    }

    public long getTimeToLoad() {
        return getDomComplete() - getDomInteractive();
    }

    public long getOnload() {
        return getLoadEventEnd() - getLoadEventStart();
    }

    public long getTotalTime() {
        return getLoadEventEnd() - getNavigationStart();
    }

    private Long getAnTime(String name) {
        return (Long) timings.get(name);
    }

    private Long getNavigationStart() {
        return getAnTime("navigationStart");
    }

    private Long getUnloadEventStart() {
        return getAnTime("unloadEventStart");
    }

    private Long getUnloadEventEnd() {
        return getAnTime("unloadEventEnd");
    }

    private Long getRedirectStart() {
        return getAnTime("redirectStart");
    }

    private Long getRedirectEnd() {
        return getAnTime("redirectEnd");
    }

    private Long getFetchStart() {
        return getAnTime("fetchStart");
    }

    private Long getDomainLookupStart() {
        return getAnTime("domainLookupStart");
    }

    private Long getDomainLookupEnd() {
        return getAnTime("domainLookupEnd");
    }

    private Long getConnectStart() {
        return getAnTime("connectStart");
    }

    private Long getConnectEnd() {
        return getAnTime("connectEnd");
    }

    private Long getSecureConnectionStart() {
        return getAnTime("secureConnectionStart");
    }

    private Long getRequestStart() {
        return getAnTime("requestStart");
    }

    private Long getResponseStart() {
        return getAnTime("responseStart");
    }

    private Long getResponseEnd() {
        return getAnTime("responseEnd");
    }

    private Long getDomLoading() {
        return getAnTime("domLoading");
    }

    private Long getDomInteractive() {
        return getAnTime("domInteractive");
    }

    private Long getDomContentLoadedEventStart() {
        return getAnTime("domContentLoadedEventStart");
    }

    private Long getDomContentLoadedEventEnd() {
        return getAnTime("domContentLoadedEventEnd");
    }

    private Long getDomComplete() {
        return getAnTime("domComplete");
    }

    private Long getLoadEventStart() {
        return getAnTime("loadEventStart");
    }

    private Long getLoadEventEnd() {
        return getAnTime("loadEventEnd");
    }

}
