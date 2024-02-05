<%@ Page Title="" Language="C#" MasterPageFile="~/Forms/Masters/Admin.master" AutoEventWireup="true" CodeFile="Createhandbook.aspx.cs" Inherits="Forms_Admin_Createhandbook" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
    <link href="../../App_Themes/Theme/SkinFile.skin" rel="stylesheet" />

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Enter Handbook Datails 
        <br />
        <hr />
    </div>
    <div class="Form Title20">

        <div class="form-group">
            <asp:Label ID="lblid" runat="server" Text="Enter Class " AssociatedControlID="txtid" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtid" runat="server" Placeholder="class" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtUserName" runat="server" ErrorMessage="Please enter class" ControlToValidate="txtid" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>

        

        <div class="form-group ">
            <asp:Label ID="Label2" runat="server" Text="Upload Your Handbook:" SkinID="lbl"></asp:Label>
            <asp:FileUpload ID="FileUpload1" runat="server" />
        </div>
    </div>

    <div class="form-group " style="text-align: center;font-size:25px;">
        <asp:Button ID="btnsubmit" CssClass="btn btn-info" OnClick="btnclick" runat="server" Text="Submit" SkinID="btn" />
    </div>


</asp:Content>

