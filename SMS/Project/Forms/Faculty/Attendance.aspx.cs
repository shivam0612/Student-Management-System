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

public partial class Forms_Faculty_Attendance : System.Web.UI.Page
{

    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    {
        if ((!IsPostBack))
        {
            OleDbCommand cmd = new OleDbCommand("select id,name from Student where class = @class");
            cmd.Parameters.AddWithValue("@class", Session["class"]);
            DataTable dt = dal.getData(cmd);
            GridView1.DataSource = dt;
            GridView1.DataBind();
            String s = Convert.ToString(Session["class"]);
            lblclass.Text = s;

        } }



    protected void btnSubmit_Click(object sender, EventArgs e)
    {
        int count = 0;
        foreach (GridViewRow row in GridView1.Rows)
        {
            if (row.RowType == DataControlRowType.DataRow)
            {
                CheckBox chkbx = row.FindControl("chkbx") as CheckBox;
                string attendanceStatus;

                if (chkbx.Checked)
                {
                    attendanceStatus = "P";
                    count++;
                }
                else
                {
                    attendanceStatus = "A";
                }
                OleDbCommand cmd = new OleDbCommand("insert into Attendance(sid,name,cdate,status,class) values(@sid,@name,@cdate,@status,@class)");
               
                cmd.Parameters.AddWithValue("@sid", row.Cells[0].Text);
                cmd.Parameters.AddWithValue("@name", row.Cells[1].Text);
                cmd.Parameters.AddWithValue("@cdate", DateTime.Today.ToString("dd/MM/yyyy"));
                cmd.Parameters.AddWithValue("@status", attendanceStatus);
                cmd.Parameters.AddWithValue("@class", Session["class"]);
               dal.Execute(cmd);
                
            }

        }
        Interaction.MsgBox("Total Present "+count);
    } 
}