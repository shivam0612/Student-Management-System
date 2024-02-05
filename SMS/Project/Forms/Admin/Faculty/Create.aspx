<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/masters/Admin.master" AutoEventWireup="true" CodeFile="Create.aspx.cs" Inherits="Forms_Admin_Entity_Create" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
    <div class="Form">
        <h1>Create</h1>
        <hr />
        <!------------------------------->
       
        <div class="form-group">
            <asp:Label ID="lblName" runat="server" Text="Name" AssociatedControlID="txtName" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtName" runat="server" placeholder="Enter name" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredName" runat="server" ErrorMessage="Name required" ControlToValidate="txtName" Display="Dynamic" ForeColor="Red" Font-Size="18px"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ID="regexname" runat="server" ControlToValidate="txtName"
                ValidationExpression="[a-zA-Z ]*$" ErrorMessage="*Valid characters: Alphabets and space." Display="Dynamic" ForeColor="Red" Font-Size="18px" />
        </div>
        <div class="form-group">
            <asp:Label ID="lblAddress" runat="server" Text="Address" AssociatedControlID="txtAddress" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtAddress" runat="server" placeholder="Enter address" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredAddress" runat="server" ErrorMessage="Address required" ControlToValidate="txtAddress" Display="Dynamic" ForeColor="Red" Font-Size="18px"></asp:RequiredFieldValidator>
            <asp:RegularExpressionValidator ID="regexAddress" runat="server" ControlToValidate="txtAddress"
                ValidationExpression="[a-zA-Z ]*$" ErrorMessage="*Valid characters: Alphabets and space." Display="Dynamic" ForeColor="Red" Font-Size="18px" />
        </div>


        <div class="form-group">
            <asp:Label ID="lblContact" runat="server" Text="Contact" AssociatedControlID="txtContact" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtContact" runat="server" placeholder="Enter contact" SkinID="txt"></asp:TextBox>
        </div>

        <div class="form-group">
            <asp:Label ID="lblEmail" runat="server" Text="E-mail" AssociatedControlID="txtEmail" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtEmail" runat="server" placeholder="Enter email" SkinID="txt"></asp:TextBox>
        </div>

        <div class="form-group">
            <asp:Label ID="lblQualification" runat="server" Text="Qualification" AssociatedControlID="txtQualification" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtQualification" runat="server" placeholder="Enter qualification" SkinID="txt"></asp:TextBox>
        </div>

         <div class="form-group">
            <asp:Label ID="lblclass" runat="server" Text="class" AssociatedControlID="txtclass" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtclass" runat="server" placeholder="enter class" SkinID="txt"></asp:TextBox>
        </div>



        <!-------------->
        <div class="form-group" style="text-align: center;">
            <asp:Button ID="btnCreate" runat="server" Text="Create" OnClick="btnCreate_Click" SkinID="btn" />
        </div>
        <div class="row">
            <div class="col-md-12">
                <a href="Default.aspx">Back to list</a>
            </div>
        </div>
    </div>
</asp:Content>

