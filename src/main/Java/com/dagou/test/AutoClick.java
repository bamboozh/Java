package com.dagou.test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoClick {
    private String[] getURL(String path) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        List<String> urls=new ArrayList<>();
        while((line=br.readLine())!=null){
            urls.add(line);
        }
        fis.close();
        isr.close();
        br.close();
        return  urls.toArray(new String[0]);
    }
    public void clickLink() throws InterruptedException, IOException {
        String[] urls=getURL("E:\\url.txt");
        String url;
        for(int i=0; i<urls.length;i++){
            url=urls[i];
            for(int j=0;j<50;j++) {
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
                ChromeOptions options=new ChromeOptions();
                options.addArguments("incognito");
                options.addArguments("headless");
                options.addArguments( "user-agent=Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
                DesiredCapabilities capabilities=new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                WebDriver driver = new ChromeDriver(capabilities);
                driver.get(url);
                Thread.sleep(5000);
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(2000);
                //driver.manage().deleteAllCookies();
                driver.close();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        AutoClick autoClick=new AutoClick();
        autoClick.clickLink();
    }
    }

