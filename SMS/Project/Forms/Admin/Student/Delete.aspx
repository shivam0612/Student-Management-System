<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/masters/Admin.master" AutoEventWireup="true" CodeFile="Delete.aspx.cs" Inherits="Forms_Admin_Entity_Delete" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">
    <asp:ScriptManager ID="ScriptManager1" runat="server">
    </asp:ScriptManager>
    <div class="Form">
        <h1>Delete</h1>
        <hr />

        <!---------------------------------------------------->
       <asp:Panel runat="server" ID="Panel2" HorizontalAlign="Center">
            <asp:Image ID="profile" CssClass="profilepicture" runat="server" />
        </asp:Panel>
        <div class="form-group">
            <asp:Label ID="lblName" runat="server" Text="Name : " AssociatedControlID="txtName" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtName" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>

        <div class="form-group">
            <asp:Label ID="lblAddress" runat="server" Text="Address : " AssociatedControlID="txtAddress" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtAddress" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>

        <div class="form-group">
            <asp:Label ID="lblContact" runat="server" Text="Contact : " AssociatedControlID="txtContact" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtContact" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>

        <div class="form-group">
            <asp:Label ID="lblEmail" runat="server" Text="Email : " AssociatedControlID="txtEmail" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtEmail" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>


        <div class="form-group">
            <asp:Label ID="lbldob" runat="server" Text="Date of birth : " AssociatedControlID="txtdob" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtdob" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>

        <div class="form-group">
            <asp:Label ID="lblclass" runat="server" Text="Class : " AssociatedControlID="txtclass" SkinID="lbl"></asp:Label>
            <asp:Label ID="txtclass" runat="server" Text="" SkinID="lbl" CssClass="form-control"></asp:Label>
        </div>

        <!-------------------------------------------------------->
        <div class="row">
            <div class="col-md-12">
                <asp:LinkButton ID="btnDelete" runat="server" CommandName="Delete" Text="Delete" OnClick="btnDelete_Click" SkinID="linkbtn" />
                |<a href="Default.aspx"> Back to list</a>
            </div>
        </div>

    </div>

</asp:Content>

