package Login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class RecuperadorBLOB
{
	private static String pathname;
    public static void RecuperarBLOB
    (Connection cn,  String nombre, String path)
    throws SQLException, IOException
    {
    	JFileChooser filechooser = new JFileChooser();
        FileOutputStream fos = null;
        Statement st = null;
        ResultSet rs = null;
        String sql ="select ARCHIVO,NOMBRE from entrenamientos WHERE NOMBRE = '" + nombre + "' ";
      
        try{
            st = cn.createStatement();        
            rs = st.executeQuery(sql);
            if (rs.next()) 
            {        
            	
            	int returnVal = filechooser.showSaveDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file1 = filechooser.getSelectedFile();
					
					pathname = file1.getAbsolutePath();
					
				} else {
					return;
				}
            	
               
                File file = new File(pathname);
                fos = new FileOutputStream(file+".pdf");                    
                Blob bin = rs.getBlob("ARCHIVO");
                InputStream inStream = bin.getBinaryStream();
                int size = (int)bin.length();
                byte[] buffer = new byte[size];
                int length = -1;
                while ((length = inStream.read(buffer)) != -1)
                {
                  fos.write(buffer, 0, length);  
                  JOptionPane.showMessageDialog(null, "El archivo se ha descargado correctamente");
      			
                }                                        
            }
        }
        catch (IOException ioe)
        {
            throw new IOException(ioe.getMessage());
        }
        finally 
        {
            if (fos != null)
                fos.close();
            if (rs != null)
                rs.close();
            rs = null;
            st = null;        
        }        
    }
}
