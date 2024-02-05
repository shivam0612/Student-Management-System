using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.OleDb;
using Microsoft.VisualBasic;
using DataAccessLayer;
public partial class Forms_Admin_Entity_Delete : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;
    int Id;
    protected void Page_Load(object sender, EventArgs e)
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

    protected void btnDelete_Click(object sender, EventArgs e)
    {
        OleDbCommand cmd = new OleDbCommand("delete from [Student] where Id=@Id");
        cmd.Parameters.AddWithValue("@Id", Id);
        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Deleted Successfully");
            Response.Redirect("/Forms/Admin/Student/Default.aspx");
        }
        else
        {
            Interaction.MsgBox("Error while deleting");
        }
            
    }
}