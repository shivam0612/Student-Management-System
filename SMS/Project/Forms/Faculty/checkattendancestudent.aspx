<%@ Page Title="" Theme="Theme" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="checkattendancestudent.aspx.cs" Inherits="Forms_Faculty_checkattendancedate" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Check Your Attendance 

         <br />
        <hr />
    </div>

    <div class="col-md-3"></div>
    <div class="form-group col-md-6">
        <br />

        <asp:label id="lblid" runat="server" text="Enter id" associatedcontrolid="txtid" skinid="lbl"></asp:label>
        <asp:textbox id="txtid" runat="server" placeholder="enter student id" skinid="txt"></asp:textbox>
        <asp:requiredfieldvalidator id="Requiredvaliddate" runat="server" errormessage="please enter id " controltovalidate="txtid" display="Dynamic" forecolor="Red" font-size="Large"></asp:requiredfieldvalidator>

        <br />
        <asp:label id="status" runat="server" text="Enter status to check attendance" associatedcontrolid="txtenterstatus" skinid="lbl"></asp:label>
        <asp:textbox id="txtenterstatus" runat="server" placeholder="enter P else A" skinid="txt"></asp:textbox>
        <asp:requiredfieldvalidator id="RequiredFieldValidator1" runat="server" errormessage="please enter status " controltovalidate="txtenterstatus" display="Dynamic" forecolor="Red" font-size="Large"></asp:requiredfieldvalidator>


    </div>
    <div class="col-md-3" style="margin-bottom: 30px"></div>

    <div class="form-group col-md-12" style="text-align: center; margin-bottom: 50px;">
        <asp:button id="btnfind" runat="server" text="check" skinid="btn" onclick="btnfind_Click" />
        <br />
    </div>




    <div class="col-md-12 TitleCenter40" contenteditable="false">
               <asp:Label ID="lblclass" runat="server"></asp:Label>


        <asp:gridview id="GridView1" runat="server" cellpadding="5" forecolor="#333333" gridlines="None" autogeneratecolumns="False" datakeynames="Id" width="100%" viewstatemode="Enabled">
            <AlternatingRowStyle BackColor="White" ForeColor="#284775" />

            <Columns>
                <asp:BoundField DataField="cdate" HeaderStyle-CssClass="gridheader" HeaderText="Date" SortExpression="cdate" ApplyFormatInEditMode="True" >
<HeaderStyle CssClass="gridheader"></HeaderStyle>
                </asp:BoundField>
            </Columns>
            <EditRowStyle BackColor="#999999" />
            <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />

        </asp:gridview>
        <br />

    </div>
</asp:Content>

