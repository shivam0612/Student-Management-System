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
            OleDbCommand cmd = new OleDbCommand("select * from [Faculty] where Id=" + Id);
            DataTable dt = dal.getData(cmd);


            txtName.Text = dt.Rows[0]["name"].ToString();
            txtAddress.Text = dt.Rows[0]["address"].ToString();
            txtContact.Text = dt.Rows[0]["contact"].ToString();
            txtEmail.Text = dt.Rows[0]["email"].ToString();
            txtQualification.Text = dt.Rows[0]["qualification"].ToString();
            txtclass.Text = dt.Rows[0]["class"].ToString();
            txtpassword.Text = dt.Rows[0]["pass"].ToString();
        }
    }
    protected void btnSave_Click(object sender, EventArgs e)
    {
        Id = int.Parse(Request.QueryString["Id"].ToString());
        OleDbCommand cmd = new OleDbCommand("update [Faculty] set name=@name,address=@address,contact=@contact,email=@email,qualification=@qualification,pass=@pass where Id=" + Id);
        cmd.Parameters.AddWithValue("@name", txtName.Text);
        cmd.Parameters.AddWithValue("@address", txtAddress.Text);
        cmd.Parameters.AddWithValue("@contact", txtContact.Text);
        cmd.Parameters.AddWithValue("@email", txtEmail.Text);
        cmd.Parameters.AddWithValue("@qualification",txtQualification.Text);
        cmd.Parameters.AddWithValue("@pass", txtpassword.Text);



        if (dal.Execute(cmd)) {
            Interaction.MsgBox("Updated successfully");
            Response.Redirect("/Forms/Admin/Faculty/Default.aspx");
        }
            

        else
            Interaction.MsgBox("Error while updating");
    }
}