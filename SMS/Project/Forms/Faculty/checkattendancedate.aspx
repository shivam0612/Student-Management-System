<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="checkattendancedate.aspx.cs" Inherits="Forms_Faculty_checkattendancestudent" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit" %>
<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
    <style type="text/css">
        .mycheckBig input {
            width: 22px;
            height: 22px;
        }
    </style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <asp:ScriptManager ID="ScriptManager1" runat="server">
    </asp:ScriptManager>
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Check Your Attendance 

         <br />
        <hr />
    </div>
    <div class="col-md-3"></div>

    <div class="form-group col-md-6">

        <br />
        <asp:Label ID="lblenterdate" runat="server" Text="Enter Date" AssociatedControlID="txtenterdate" SkinID="lbl"></asp:Label>
        <asp:TextBox ID="txtenterdate" runat="server" placeholder="enter date in xx-xx-xxxx maner" SkinID="txt"></asp:TextBox>
        <ajaxToolkit:CalendarExtender ID="Calendar1" runat="server" BehaviorID="txtenterdate_CalendarExtender" TargetControlID="txtenterdate"></ajaxToolkit:CalendarExtender>
        <asp:RequiredFieldValidator ID="Requiredvaliddate" runat="server" ErrorMessage="please enter date " ControlToValidate="txtenterdate" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        <br />

        <asp:Label ID="status" runat="server" Text="Enter status to check attendance" AssociatedControlID="txtenterstatus" SkinID="lbl"></asp:Label>
        <asp:TextBox ID="txtenterstatus" runat="server" placeholder="enter P else A" SkinID="txt"></asp:TextBox>
        <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="please ente status " ControlToValidate="txtenterstatus" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>

    </div>
    <div class="col-md-3" style="margin-bottom: 30px"></div>

    <div class="form-group col-md-12" style="text-align: center; margin-bottom: 50px;">
        <asp:Button ID="btnfind" runat="server" Text="check" SkinID="btn" OnClick="btnfind_Click" />
        <br />
    </div>
    
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        
       <asp:Label ID="lblclass" runat="server"></asp:Label>
        
        <asp:GridView ID="GridView1" runat="server" CellPadding="5" ForeColor="#333333" GridLines="None" AutoGenerateColumns="False" DataKeyNames="sid" Width="100%" ViewStateMode="Enabled" OnSelectedIndexChanged="GridView1_SelectedIndexChanged">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />

            <Columns>
                <asp:BoundField DataField="sid" HeaderText="student id" InsertVisible="False" ReadOnly="True" SortExpression="sid" HeaderStyle-CssClass="gridheader" />
                <asp:BoundField DataField="name" HeaderText="Name" SortExpression="name" ApplyFormatInEditMode="True" HeaderStyle-CssClass="gridheader" />
            </Columns>

            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />

        </asp:GridView>
        <br />
    </div>

</asp:Content>

