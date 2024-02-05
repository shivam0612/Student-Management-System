using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class Forms_Admin_Student_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void GridIndex_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "Details")
        {
            GridViewRow gvr = (GridViewRow)(((LinkButton)e.CommandSource).NamingContainer);
            int RowIndex = gvr.RowIndex;

            int Id = Convert.ToInt32(GridIndex.Rows[RowIndex].Cells[0].Text);
            Response.Redirect("Details.aspx?Id=" + Id);
        }
    }

    protected void GridIndex_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        int rowIndex = e.RowIndex;
        Response.Redirect("Delete.aspx?Id=" + GridIndex.Rows[rowIndex].Cells[0].Text);

    }

    protected void GridIndex_RowEditing(object sender, GridViewEditEventArgs e)
    {
        int Id = Convert.ToInt32(GridIndex.Rows[e.NewEditIndex].Cells[0].Text);
        Response.Redirect("Edit.aspx?Id=" + Id);

    }

    protected void GridIndex_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}