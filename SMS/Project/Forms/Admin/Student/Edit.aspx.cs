using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.OleDb;
using DataAccessLayer;
using Microsoft.VisualBasic;
public partial class Forms_Admin_Entity_Edit : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;
    int Id;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            Id = int.Parse(Request.QueryString["Id"].ToString());
            OleDbCommand cmd = new OleDbCommand("select * from [Student] where Id=" + Id);
            DataTable dt = dal.getData(cmd);


            profile.ImageUrl = dt.Rows[0]["Images"].ToString();
            txtName.Text = dt.Rows[0]["name"].ToString();
            txtAddress.Text = dt.Rows[0]["address"].ToString();
            txtContact.Text = dt.Rows[0]["contact"].ToString();
            txtEmail.Text = dt.Rows[0]["email"].ToString();
            txtdob.Text = dt.Rows[0]["dob"].ToString();
            txtclass.Text = dt.Rows[0]["class"].ToString();
        }
    }
    protected void btnSave_Click(object sender, EventArgs e)
    {
        string str = FileUpload1.FileName;
        FileUpload1.PostedFile.SaveAs(Server.MapPath("~/Images/" + str));
        string Image = "~/Images/" + str.ToString();



        Id = int.Parse(Request.QueryString["Id"].ToString());
        OleDbCommand cmd = new OleDbCommand("update [Student] set name=@name,address=@address,contact=@contact,email=@email,dob=@dob,class=@class,Images=@Images where Id=" + Id);
        cmd.Parameters.AddWithValue("@name", txtName.Text);
        cmd.Parameters.AddWithValue("@address", txtAddress.Text);
        cmd.Parameters.AddWithValue("@contact", txtContact.Text);
        cmd.Parameters.AddWithValue("@email", txtEmail.Text);
        cmd.Parameters.AddWithValue("@dob", txtdob.Text);
        cmd.Parameters.AddWithValue("@class", txtclass.Text);
        cmd.Parameters.AddWithValue("Images", Image);


        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Updated successfully");
            Response.Redirect("/Forms/Admin/Student/Default.aspx");
        }


        else
            Interaction.MsgBox("Error while updating");
    }

   



}