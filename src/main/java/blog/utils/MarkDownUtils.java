package blog.utils;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Arrays;

public class MarkDownUtils {


    //markdown转html
    public static String markdownToHtml(String markdown){

        MutableDataSet options = new MutableDataSet();

        options.setFrom(ParserEmulationProfile.MARKDOWN); //enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}
