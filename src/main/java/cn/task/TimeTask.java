package cn.task;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务 抓取内容
 * @author Administrator
 *
 */
@Component
public class TimeTask {
	
	@Scheduled(cron = "0/5 * * * * *")
//	@Scheduled(fixedRate = 5000)
	public void scheduled() throws Exception{
		
		 TutorialCrawler crawler = new TutorialCrawler("crawler", true);
		 crawler.addSeed("http://www.xue63.com/");
	        crawler.addRegex("http://www.xue63.com/.*");

	        /*可以设置每个线程visit的间隔，这里是毫秒*/
	        //crawler.setVisitInterval(1000);
	        /*可以设置http请求重试的间隔，这里是毫秒*/
	        //crawler.setRetryInterval(1000);
	        crawler.setThreads(1);
	        crawler.start(1);
	      
 
    }

}
