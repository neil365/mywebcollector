package cn.task;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class TutorialCrawler extends BreadthCrawler {

    public TutorialCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }

    /*
        可以往next中添加希望后续爬取的任务，任务可以是URL或者CrawlDatum
        爬虫不会重复爬取任务，从2.20版之后，爬虫根据CrawlDatum的key去重，而不是URL
        因此如果希望重复爬取某个URL，只要将CrawlDatum的key设置为一个历史中不存在的值即可
        例如增量爬取，可以使用 爬取时间+URL作为key。

        新版本中，可以直接通过 page.select(css选择器)方法来抽取网页中的信息，等价于
        page.getDoc().select(css选择器)方法，page.getDoc()获取到的是Jsoup中的
        Document对象，细节请参考Jsoup教程
    */
    @Override
    public void visit(Page page, CrawlDatums next) {
    	System.out.println("=========");
        if (page.matchUrl("http://www.xue63.com/.*")) {
        	
//        	Element div = page.select("div[class=pic-news clearfix]").first();
        	Elements divs = page.select("div[class=pic-news clearfix]");
        	for(Element a : divs) {
        		Element a1 = a.getElementsByAttribute("href").first();
        		String href = a1.attr("title");
        		System.out.println("title:" + href );
        	}
        	
          
        	
        	
//            String title = page.select("div[class=title]").first().text();
//            String author = page.select("div[id=blog_userface]").first().text();
            
        }
    }

    
    
    public static void main(String[] args) throws Exception {
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
