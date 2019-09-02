package cn.itsource.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * @author kl by 2016/3/14
 * @boke www.kailing.pub
 */
public class Searcher {
    public static void search(String indexDir,String q)throws Exception{
        Directory dir= FSDirectory.open(Paths.get(indexDir));//索引地址
        IndexReader reader= DirectoryReader.open(dir);//读索引
        IndexSearcher is=new IndexSearcher(reader);
        Analyzer analyzer=new StandardAnalyzer(); // 标准分词器
        QueryParser parser=new QueryParser("context", analyzer);//指定查询Document的某个属性
        Query query=parser.parse(q);//指定查询索引内容，对应某个分词
        TopDocs hits=is.search(query, 10);//执行搜索
        System.out.println("匹配 "+q+"查询到"+hits.totalHits+"个记录");
        for(ScoreDoc scoreDoc:hits.scoreDocs){
            Document doc=is.doc(scoreDoc.doc);
            System.out.println(doc.get("fileName"));//打印Document的fileName属性
        }
        reader.close();
    }
    public static void main(String[] args) {
        String indexDir="G:\\lucene\\LuceneIndex";
        String q="Muir";
        try {
            search(indexDir,q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}