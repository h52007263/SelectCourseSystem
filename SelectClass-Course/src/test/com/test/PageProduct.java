package com.test;

import com.model.Product;
import com.utils.ProductUtil;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hzs
 * @description 对全文检索出来的数据进行分页
 * @date 2019/5/28 10:16
 */
public class PageProduct {
    public static void main(String[] args) throws Exception {
        // 1. 准备中文分词器
        IKAnalyzer analyzer = new IKAnalyzer();
        // 2. 索引
        Directory index = createIndex(analyzer);

        // 3. 查询器

        String keyword = "手机";
        System.out.println("当前关键字是："+keyword);
        Query query = new QueryParser( "name", analyzer).parse(keyword);

        // 4. 搜索
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher=new IndexSearcher(reader);
        int pageNow = 2;
        int pageSize = 5;

        ScoreDoc[] hits = pageSearch1(query, searcher, pageNow, pageSize);

        // 5. 显示查询结果
        showSearchResults(searcher, hits,query,analyzer);
        // 6. 关闭查询
        reader.close();

    }

    private static ScoreDoc[] pageSearch1(Query query, IndexSearcher searcher, int pageNow, int pageSize)
            throws IOException {
        //topDocs是前pageNow*pageSize条数据，没有文档，词汇表中进行检索
        TopDocs topDocs = searcher.search(query, pageNow*pageSize);
        System.out.println("查询到的总条数\t"+topDocs.totalHits);
        //【分页前的集合，数据记录是总的】文档集合,里面有多个docuemnt，通过Docuemnt d=allScores.doc获取
        ScoreDoc [] alllScores = topDocs.scoreDocs;

        //文档【检索的结果】集合
        List<ScoreDoc> hitScores = new ArrayList<>();

        int start = (pageNow -1)*pageSize ;
        int end = pageSize*pageNow;
        for(int i=start;i<end;i++)
            hitScores.add(alllScores[i]);

        //筛选出当前页的集合
        ScoreDoc[] hits = hitScores.toArray(new ScoreDoc[]{});
        return hits;
    }

    private static void showSearchResults(IndexSearcher searcher, ScoreDoc[] hits, Query query, IKAnalyzer analyzer) throws Exception {
        System.out.println("找到 " + hits.length + " 个命中.");

        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));

        System.out.println("找到 " + hits.length + " 个命中.");
        System.out.println("序号\t匹配度得分\t结果");
        for (int i = 0; i < hits.length; ++i) {
            ScoreDoc scoreDoc= hits[i];
            int docId = scoreDoc.doc;
            Document d = searcher.doc(docId);
            List<IndexableField> fields= d.getFields();
            System.out.print((i + 1) );
            System.out.print("\t" + scoreDoc.score);
            for (IndexableField f : fields) {

                if("name".equals(f.name())){
                    TokenStream tokenStream = analyzer.tokenStream(f.name(), new StringReader(d.get(f.name())));
                    String fieldContent = highlighter.getBestFragment(tokenStream, d.get(f.name()));
                    System.out.print("\t"+fieldContent);
                }
                else{
                    System.out.print("\t"+d.get(f.name()));
                }
            }
            System.out.println("<br>");
        }
    }

    private static Directory createIndex(IKAnalyzer analyzer) throws IOException {
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(index, config);
        String fileName="E:\\download\\jar\\lib_lucene\\source\\140k_products\\4k_products.txt";
        List<Product> products = ProductUtil.file2list(fileName);
        int total = products.size();
        int count = 0;
        int per = 0;
        int oldPer =0;
        for (Product p : products) {
            addDoc(writer, p);
            count++;
            per = count*100/total;
            if(per!=oldPer){
                oldPer = per;
                System.out.printf("索引中，总共要添加 %d 条记录，当前添加进度是： %d%% %n",total,per);
            }

        }
        writer.close();
        return index;
    }

    private static void addDoc(IndexWriter w, Product p) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("id", String.valueOf(p.getId()), Field.Store.YES));
        doc.add(new TextField("name", p.getName(), Field.Store.YES));
        doc.add(new TextField("category", p.getCategory(), Field.Store.YES));
        doc.add(new TextField("price", String.valueOf(p.getPrice()), Field.Store.YES));
        doc.add(new TextField("place", p.getPlace(), Field.Store.YES));
        doc.add(new TextField("code", p.getCode(), Field.Store.YES));
        w.addDocument(doc);
    }
}
