package com.md.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.md.entity.Customer;
import com.md.entity.DiagnoseResult;

@Service
public class PDFUtils {

	private static Font headfont;// 设置字体大小
	private static Font keyfont;// 设置字体大小
	private static Font textfont;// 设置字体大小

	static {
		BaseFont bfChinese;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.NOT_EMBEDDED);
			headfont = new Font(bfChinese, 14, Font.BOLD);// 设置字体大小
			keyfont = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小
			textfont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	int maxWidth = 520;  

	/**
	 * @param generateFilePath pdf生成的路径
	 * @param docSignPath 医生签名图片
	 * @throws Exception
	 */
	public void writePdf(DiagnoseResult diagnoseResult,Customer customer,String generateFilePath,String docSignPath) throws Exception {
		// 1.新建document对象
		// 第一个参数是页面大小。接下来的参数分别是左、右、上和下页边距。
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		
		// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
		// 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
		PdfWriter.getInstance(document,new FileOutputStream(generateFilePath));
		
		// 3.打开文档
		document.open();
		
		// 4.向文档中添加内容
		// 通过 com.lowagie.text.Paragraph 来添加文本。可以用文本及其默认的字体、颜色、大小等等设置来创建一个默认段落
		Paragraph pt = new Paragraph( "诊断结果", headfont);// 设置字体样式
		pt.setAlignment(1);// 设置文字居中 0靠左 1，居中 2，靠右
		document.add(pt);
		document.add(new Paragraph("\n"));
		
		//创建一表格
		float[] widths ={25,10,15,25,25};
		PdfPTable table = this.createTable(widths);  
		
		//第一行
		table.addCell(createCell("诊断时间：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getDiagnose_result_date()+" "+diagnoseResult.getDiagnose_result_time(), textfont, 0,2));
		table.addCell(createCell("初诊/复诊：", keyfont, 2));
		String isFirstDiagnose = "复诊";
		if(diagnoseResult.getIs_first_diagnose()==1){
			isFirstDiagnose = "初诊";
		}
		table.addCell(createCell(isFirstDiagnose, textfont, 0));
		
		//第二行
		table.addCell(createCell("登录人姓名：", keyfont, 2));
		table.addCell(createCell(customer.getName(), textfont, 0,2));
		table.addCell(createCell("病人姓名：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getSick_name(), textfont, 0));
		
		//第三行
		String sick_sex = "女性";
		if(diagnoseResult.getSex()==1){
			sick_sex = "男性";
		}
		table.addCell(createCell("病人性别：", keyfont, 2));
		table.addCell(createCell(sick_sex, textfont, 0,2));
		table.addCell(createCell("病人年龄：", keyfont, 2));
		String age = "";
		if(null != diagnoseResult.getSick_age()){
			age = String.valueOf(diagnoseResult.getSick_age());
		}
		table.addCell(createCell(""+age, textfont, 0));
		
		//第四行
		table.addCell(createCell("主诉：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getReport(), textfont, 0,4));
		
		//第五行
		table.addCell(createCell("病史与检查：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getMedical_history(), textfont, 0,4));
		
		//第六行
		table.addCell(createCell("输入的症状：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getLessSymptomValue(), textfont, 0,4));
		
		//第七行
		table.addCell(createCell("主要症状：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getSymptom_prescription_name(), textfont, 0,4));
	  
		//第八行
		table.addCell(createCell("（内）病位：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getIn_bw_first_name()+"，"+diagnoseResult.getIn_bw_second_name(), textfont, 0,2));
		table.addCell(createCell("（外）病位：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getOut_bw_name(), textfont, 0));
		
		//第九行
		table.addCell(createCell("（内）病因：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getIn_by_first_name()+"，"+diagnoseResult.getIn_by_second_name(), textfont, 0,2));
		table.addCell(createCell("（外）病因：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getOut_by_name(), textfont, 0));
		
		//第十行
		table.addCell(createCell("医生确诊处方：", keyfont, 2));
		table.addCell(createCell(diagnoseResult.getPrescription6_medicinal(), textfont, 0,4));
		
		//第十一行
		table.addCell(createCell("注意事项：", keyfont, 2));
		table.addCell(createCell("（用法及禁忌：3剂， 每日1剂 ，中火水煎 ，温服， 忌食生冷腥辣油腻）", textfont, 0,4));
		
		//第十二行
		table.addCell(createCell("医生签名：", keyfont, 2));
		
		File imageFile = new File(docSignPath); 
		if(imageFile.exists()){
			Image image = Image.getInstance(docSignPath);
			PdfPCell cellImage = new PdfPCell();    
			cellImage.setVerticalAlignment(Element.ALIGN_MIDDLE);    
			cellImage.setHorizontalAlignment(0);        
			cellImage.setImage(image);
	        
	        //设置边框为白色,相当于隐藏
			cellImage.setBorderColor(BaseColor.WHITE);
			cellImage.setUseBorderPadding(true);
	        
	        //设置表格差距
			cellImage.setBorderWidthTop(5f);
	        table.addCell(cellImage);
		}
		
		table.completeRow();
		document.add(table);
       
		// 5.关闭文档
		document.close();
	}

    /**
     * 创建表格  (设置内容存放位置)
     * @param value 内容
     * @param font  字体
     * @param align  位置
     * @return
     */
    public PdfPCell createCell(String value,Font font,int align){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);            
        cell.setHorizontalAlignment(align);        
        cell.setPhrase(new Phrase(value,font));  
        
        //设置边框为白色,相当于隐藏
        cell.setBorderColor(BaseColor.WHITE);
        cell.setUseBorderPadding(true);
        
        //设置表格差距
        cell.setBorderWidthTop(5f);
        
        return cell;    
    }    
       
    /**
     * 创建表格  (设置内容存放位置 默认中间)
     * @param value 内容
     * @param font  字体
     * @return
     */
    public PdfPCell createCell(String value,Font font){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);     
        cell.setPhrase(new Phrase(value,font));    
       return cell;    
   }    
   
    /**
     * 创建表格  (设置内容存放位置)  跨度
     * @param value 内容
     * @param font  字体
     * @param align  位置
     * @param colspan 跨度
     * @return
     */
   public PdfPCell createCell(String value,Font font,int align,int colspan){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
        cell.setHorizontalAlignment(align);        
        cell.setColspan(colspan);    
        cell.setPhrase(new Phrase(value,font));   
        
        //设置边框为白色,相当于隐藏
        cell.setBorderColor(BaseColor.WHITE);
        cell.setUseBorderPadding(true);
        
        //设置表格差距
        cell.setBorderWidthTop(5f);
       return cell;    
   }    
   
   /**
    * 
    * 创建表格  (设置内容存放位置)  跨度
     * @param value 内容
     * @param font  字体
     * @param align  位置
    * @param colspan  跨度
    * @param boderFlag 表格样式
    * @return
    */
   public PdfPCell createCell(String value,Font font,int align,int colspan,boolean boderFlag){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
        cell.setHorizontalAlignment(align);        
        cell.setColspan(colspan);    
        cell.setPhrase(new Phrase(value,font));    
        cell.setPadding(3.0f);    
        if(!boderFlag){    
            cell.setBorder(0);    
            cell.setPaddingTop(15.0f);    
            cell.setPaddingBottom(8.0f);    
        }    
       return cell;    
   }    
   
   /**
    * 创建表格
    * @param colNumber
    * @return
    */
   public PdfPTable createTable(int colNumber){    
       PdfPTable table = new PdfPTable(colNumber);    
       try{    
           table.setTotalWidth(maxWidth);    
           table.setLockedWidth(true);    
           table.setHorizontalAlignment(Element.ALIGN_CENTER);         
           table.getDefaultCell().setBorder(0);  
       }catch(Exception e){    
           e.printStackTrace();    
       }    
       return table;    
   }   
   
   /**
    * 
    * @param widths
    * @return
    */
	public PdfPTable createTable(float[] widths){    
	       PdfPTable table = new PdfPTable(widths);    
	       try{    
	           table.setTotalWidth(maxWidth);    
	           table.setLockedWidth(true);    
	           table.setHorizontalAlignment(Element.ALIGN_CENTER);         
	           table.getDefaultCell().setBorder(0);    
	       }catch(Exception e){    
	           e.printStackTrace();    
	       }    
	       return table;    
	   }    
       
	/**
	 * 创建表格
	 * @return
	 */
    public PdfPTable createBlankTable(){    
        PdfPTable table = new PdfPTable(1);    
        table.getDefaultCell().setBorder(0);    
        table.addCell(createCell("", keyfont));             
        table.setSpacingAfter(20.0f);    
        table.setSpacingBefore(20.0f);    
        return table;    
    }  
	

}
