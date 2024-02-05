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

public partial class Forms_Admin_Createhandbook : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;

    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnclick(object sender, EventArgs e)
    {
        string str = FileUpload1.FileName;
        FileUpload1.PostedFile.SaveAs(Server.MapPath("~/handbook/" + str));
        string Image = "~/handbook/" + str.ToString();




        OleDbCommand cmd = new OleDbCommand("Insert into [Handbook](class,handbook) values(@class,@handbook)");
        cmd.Parameters.AddWithValue("@class", txtid.Text);
        cmd.Parameters.AddWithValue("handbook",Image);

        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Created Successfully");
            Response.Redirect("/Forms/Admin/Handbook.aspx");
        }
        else
        {
            Interaction.MsgBox("Error while creating");
        }

    }

}