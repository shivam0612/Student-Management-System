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
        Random r = new Random();
        int pass = r.Next(1000, 9999);

        OleDbCommand cmd = new OleDbCommand("Insert into [Faculty](name,address,contact,email,qualification,class,pass) values(@name,@address,@contact,@email,@qualification,@class,@pass)");
        cmd.Parameters.AddWithValue("@name", txtName.Text);
        cmd.Parameters.AddWithValue("@address", txtAddress.Text);
        cmd.Parameters.AddWithValue("@contact", txtContact.Text);
        cmd.Parameters.AddWithValue("@email", txtEmail.Text);
        cmd.Parameters.AddWithValue("@qualification", txtQualification.Text);
        cmd.Parameters.AddWithValue("@class", txtclass.Text);
        cmd.Parameters.AddWithValue("@password", pass);


        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Created Successfully and password = "+pass);
       
            Response.Redirect("/Forms/Admin/Faculty/Default.aspx");

        }
        else
        {
            Interaction.MsgBox("Error while creating");
        }
    }
}