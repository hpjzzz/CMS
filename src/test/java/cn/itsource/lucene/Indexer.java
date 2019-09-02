package cn.itsource.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;


/**
 * @author kl by 2016/3/14
 * @boke www.kailing.pub
 */
public class Indexer {
	public  IndexWriter writer;
	/**
	 * 实例化写索引
	 */
	public Indexer(String indexDir)throws Exception{
		Analyzer analyzer=new StandardAnalyzer();//分词器
		IndexWriterConfig writerConfig=new IndexWriterConfig(analyzer);//写索引配置
		//Directory ramDirectory= new RAMDirectory();//索引写的内存
		Directory directory= FSDirectory.open(Paths.get(indexDir));//索引存储磁盘位置
		writer=new IndexWriter(directory,writerConfig);//实例化一个写索引
	}
	/**
	 * 关闭写索引
	 * @throws Exception
	 */
	public void close()throws Exception{
		writer.close();
	}
	/**
	 * 添加指定目录的所有文件的索引
	 * @param dataDir
	 * @return
	 * @throws Exception
	 */
	public int index(String dataDir)throws Exception{
		File[] files=new File(dataDir).listFiles();//得到指定目录的文档数组
		for(File file:files){
			indexFile(file);
		}
		return writer.numDocs();
	}
	public void indexFile(File file)throws Exception{
		System.out.println("索引文件:"+file.getCanonicalPath());//打印索引到的文件路径信息
		Document document=getDocument(file);//得到一个文档信息，相对一个表记录
		writer.addDocument(document);//写入到索引，相当于插入一个表记录
	}

	/**
	 * 返回一个文档记录
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public Document getDocument(File file)throws Exception{
		Document document=new Document();//实例化一个文档
		document.add(new TextField("context",new FileReader(file)));//添加一个文档信息，相当于一个数据库表字段
		document.add(new TextField("fileName",file.getName(), Field.Store.YES));//添加文档的名字属性
		document.add(new TextField("filePath",file.getCanonicalPath(),Field.Store.YES));//添加文档的路径属性
		return document;
	}

	public static void main(String[] args){
		String indexDir="g:\\lucene\\LuceneIndex";
		String dataDir="g:\\lucene\\LuceneTestData";
		Indexer indexer=null;
		int indexSum=0;
		try {
			indexer=new Indexer(indexDir);
			indexSum= indexer.index(dataDir);
			System.out.printf("完成"+indexSum+"个文件的索引");

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				indexer.close();
			}catch (Exception e){
				e.printStackTrace();
			}

		}

	}

}