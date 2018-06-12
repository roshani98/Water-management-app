package com.example.application.watermeter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class bill extends AppCompatActivity {
    private Button b;
    private PdfPCell cell;
    private String textAnswer;
    ListView list;
    private String path;
    private File dir;
    private File file;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        button = (Button) findViewById(R.id.button);
    }

    public void PDFGenerate(View view) throws FileNotFoundException,DocumentException{

            //create document file
            Document doc = new Document();
            try {

                Log.e("PDFCreator", "PDF Path: " + path);
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                file = new File(dir, "Trial" + sdf.format(Calendar.getInstance().getTime()) + ".pdf");
                FileOutputStream fOut = new FileOutputStream(file);
                PdfWriter writer = PdfWriter.getInstance(doc, fOut);

                //open the document
                doc.open();
//create table
                PdfPTable pt = new PdfPTable(3);
                pt.setWidthPercentage(100);
                float[] fl = new float[]{20, 45, 35};
                pt.setWidths(fl);
                cell = new PdfPCell();
                cell.setBorder(Rectangle.NO_BORDER);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                byte[] bitmapdata = stream.toByteArray();
                try {
                    pt.addCell(cell);
                    cell = new PdfPCell();
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.addElement(new Paragraph("Trinity Tuts"));

                    cell.addElement(new Paragraph(""));
                    cell.addElement(new Paragraph(""));
                    pt.addCell(cell);
                    cell = new PdfPCell(new Paragraph(""));
                    cell.setBorder(Rectangle.NO_BORDER);
                    pt.addCell(cell);

                    PdfPTable pTable = new PdfPTable(1);
                    pTable.setWidthPercentage(100);
                    cell = new PdfPCell();
                    cell.setColspan(1);
                    cell.addElement(pt);
                    pTable.addCell(cell);
                    PdfPTable table = new PdfPTable(6);

                    float[] columnWidth = new float[]{6, 30, 30, 20, 20, 30};
                    table.setWidths(columnWidth);


                    cell = new PdfPCell();

                    cell.setColspan(6);
                    cell.addElement(pTable);
                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase(" "));
                    cell.setColspan(6);
                    table.addCell(cell);
                    cell = new PdfPCell();
                    cell.setColspan(6);

                    cell = new PdfPCell(new Phrase("#"));
                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase("Header 1"));

                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase("Header 2"));
                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase("Header 3"));
                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase("Header 4"));
                    table.addCell(cell);
                    cell = new PdfPCell(new Phrase("Header 5"));
                    table.addCell(cell);

                    //table.setHeaderRows(3);
                    cell = new PdfPCell();
                    cell.setColspan(6);

                    for (int i = 1; i <= 10; i++) {
                        table.addCell(String.valueOf(i));
                        table.addCell("Header 1 row " + i);
                        table.addCell("Header 2 row " + i);
                        table.addCell("Header 3 row " + i);
                        table.addCell("Header 4 row " + i);
                        table.addCell("Header 5 row " + i);

                    }

                    PdfPTable ftable = new PdfPTable(6);
                    ftable.setWidthPercentage(100);
                    float[] columnWidthaa = new float[]{30, 10, 30, 10, 30, 10};
                    ftable.setWidths(columnWidthaa);
                    cell = new PdfPCell();
                    cell.setColspan(6);
//                    cell.setBackgroundColor(myColor1);
                    cell = new PdfPCell(new Phrase("Total Nunber"));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Phrase(""));
                    cell.setBorder(Rectangle.NO_BORDER);
//                    cell.setBackgroundColor(myColor1);
                    ftable.addCell(cell);
                    cell = new PdfPCell(new Paragraph("Footer"));
                    cell.setColspan(6);
                    ftable.addCell(cell);
                    cell = new PdfPCell();
                    cell.setColspan(6);
                    cell.addElement(ftable);
                    table.addCell(cell);
                    doc.add(table);
                    Toast.makeText(getApplicationContext(), "created PDF", Toast.LENGTH_LONG).show();
                } catch (DocumentException de) {
                    Log.e("PDFCreator", "DocumentException:" + de);
                } finally {
                    doc.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public void createPdf(View view) {

        editText = (EditText) findViewById(R.id.bill);
        Document document = new Document();
        String str = Environment.getExternalStorageDirectory() + "/myPdf.pdf";

        try {
            PdfWriter.getInstance(document,new FileOutputStream(str));
            document.open();
            document.add(new Paragraph(editText.getText().toString()));
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("Android ");
            document.addCreator("Roshani");
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}