package org.bran.module;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
/**
 * 
 *<p>Title: BookUpdatePanel.java</p>
 *<p>Description:图书更新面板 </p>
 * @author BranSummer
 * @date 2017年5月4日
 */
import javax.swing.JTextField;
public class BookUpdatePanel extends JPanel {
	//查询文本框，查询按钮
	private JTextField queryText;
	private JButton queryButton;
	//更新按钮
	private JButton updateButton;
	//修改文本框(书名，出版社，作者，价格，关键词，)
	private JTextField bookName,publishName,author,price,pageNum,keyWord;
	//修改类别
	private JComboBox<String> sort;
	private String[] bookSorts={"小说","文学","传记","艺术","少儿","社会科学","科技","教辅","历史","医学"};
	//修改备注
	private JTextArea remarks;
	/**
	 * constructor
	 */
	public BookUpdatePanel(){
		super();
		//创建分割面板
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.add(sp);
		//top面板，放置按钮及查询文本框
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(new JLabel("输入ISBN修改需要查询的图书"));
		//按钮及查询文本框面板
		JPanel inputPanel=new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.add(new JLabel("请输入书号："));
		queryText=new JTextField();
		inputPanel.add(queryText);
		queryButton=new JButton("查询");
		inputPanel.add(queryButton);
		updateButton=new JButton("确认修改");
		inputPanel.add(updateButton);
		topPanel.add(inputPanel);
		//修改项面板
		JPanel bottomPanel=new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		//书名修改面板
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(new JLabel("书　名："));
		bookName=new JTextField();
		panel1.add(bookName);
		//出版社修改面板
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(new JLabel("出版社："));
		publishName=new JTextField();
		panel2.add(publishName);
		//作者修改面板
		JPanel panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.add(new JLabel("作　者："));
		author=new JTextField();
		panel3.add(author);
		//价格修改面板
		JPanel panel4=new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		panel4.add(new JLabel("价　格："));
		price=new JTextField();
		panel4.add(price);
		//类别修改面板
		JPanel panel5=new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		panel5.add(new JLabel("类　别："));
		sort=new JComboBox<String>();
		for(int i=0;i<bookSorts.length;i++){
			sort.addItem(bookSorts[i]);
		}
		panel5.add(sort);
		//备注修改面板
		JPanel panel6=new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		panel6.add(new JLabel("备　注："));
		remarks=new JTextArea(5,20);
		panel6.add(remarks);
		//各修改项面板加入bottomPanel
		bottomPanel.add(panel1);
		bottomPanel.add(panel2);
		bottomPanel.add(panel3);
		bottomPanel.add(panel4);
		bottomPanel.add(panel5);
		bottomPanel.add(panel6);
		//topPanel,bottomPanel加入分割面板
		sp.add(topPanel, JSplitPane.TOP);
		sp.add(bottomPanel, JSplitPane.BOTTOM);
	}
}
