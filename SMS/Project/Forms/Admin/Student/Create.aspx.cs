using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Microsoft.VisualBasic;
using System.Data;
using System.Data.OleDb;
using DataAccessLayer;

public partial class Forms_Admin_Entity_Create : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnCreate_Click(object sender, EventArgs e)
    {
        string str = FileUpload1.FileName;
        FileUpload1.PostedFile.SaveAs(Server.MapPath("~/Images/" + str));
        string Image = "~/Images/" + str.ToString();
       

       
        OleDbCommand cmd = new OleDbCommand("Insert into [Student](name,address,contact,email,dob,class,Images) values(@name,@address,@contact,@email,@dob,@class,@Images)");
        cmd.Parameters.AddWithValue("@name", txtName.Text);
        cmd.Parameters.AddWithValue("@address", txtAddress.Text);
        cmd.Parameters.AddWithValue("@contact", txtContact.Text);
        cmd.Parameters.AddWithValue("@email", txtEmail.Text);
        cmd.Parameters.AddWithValue("@dob", txtdob.Text);
        cmd.Parameters.AddWithValue("@class", txtclass.Text);
        cmd.Parameters.AddWithValue("Images", Image);
        
        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Created Successfully");
            Response.Redirect("/Forms/Admin/Student/Default.aspx");
        }
        else
        {
            Interaction.MsgBox("Error while creating");
        }
    }
}