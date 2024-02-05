<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/masters/Admin.master" AutoEventWireup="true" CodeFile="Delete.aspx.cs" Inherits="Forms_Admin_Entity_Delete" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">
    <asp:scriptmanager id="ScriptManager1" runat="server">
    </asp:scriptmanager>
    <div class="Form">
        <h1>Delete</h1>
        <hr />

        <!---------------------------------------------------->
        <div class="form-group">
            <asp:label id="lblName" runat="server" text="Name : " associatedcontrolid="txtName" skinid="lbl"></asp:label>
            <asp:label id="txtName" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>

        <div class="form-group">
            <asp:label id="lblAddress" runat="server" text="Address : " associatedcontrolid="txtAddress" skinid="lbl"></asp:label>
            <asp:label id="txtAddress" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>

        <div class="form-group">
            <asp:label id="lblContact" runat="server" text="Contact : " associatedcontrolid="txtContact" skinid="lbl"></asp:label>
            <asp:label id="txtContact" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>

        <div class="form-group">
            <asp:label id="lblEmail" runat="server" text="Email : " associatedcontrolid="txtEmail" skinid="lbl"></asp:label>
            <asp:label id="txtEmail" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>


        <div class="form-group">
            <asp:label id="lblQualification" runat="server" text="Qualification : " associatedcontrolid="txtQualification" skinid="lbl"></asp:label>
            <asp:label id="txtQualification" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>

        <div class="form-group">
            <asp:label id="lblpassword" runat="server" text="password : " associatedcontrolid="txtpassword" skinid="lbl"></asp:label>
            <asp:label id="txtpassword" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>

        <div class="form-group">
            <asp:label id="lblclass" runat="server" text="class : " associatedcontrolid="txtclass" skinid="lbl"></asp:label>
            <asp:label id="txtclass" runat="server" text="" skinid="lbl" cssclass="form-control"></asp:label>
        </div>


        <!-------------------------------------------------------->
        <div class="row">
            <div class="col-md-12">
                <asp:linkbutton id="btnDelete" runat="server" commandname="Delete" text="Delete" onclick="btnDelete_Click" skinid="linkbtn" />
                |<a href="Default.aspx"> Back to list</a>
            </div>
        </div>

    </div>

</asp:Content>

