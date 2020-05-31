package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class jsoupDemo {
    public static void main(String[] args) throws IOException {
        String path = jsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());//查看Elements集合有几个元素
        //获取第一个元素
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);
    }
}
