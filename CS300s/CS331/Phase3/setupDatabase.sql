-- Setup Schema
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/eSaintCreateScript.sql

-- Setup Events
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/Item_Status_Event.sql

-- Setup Stored Procedures
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/itemCurrentOrWinningBidProc.sql
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/updateItemStatusProc.sql
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/Item_Event_Procedure.sql

-- Setup Stored Functions
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/insertAuctionBidFunc.sql
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/getSellerFeedbackFunc.sql
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/getBuyerFeedbackFunc.sql

-- Setup Triggers
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/updateCurrentBidTrigger.sql
-- source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/updateWinnerIdTrigger.sql
-- source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/someTrigger.sql

-- Setup Views
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/viewCommissionReport.sql
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/viewSalesReport.sql

-- Setup Mock Data
source ~/Dropbox/SJU/CompSci/CS300s/CS331/Phase3/scripts/insertScripts/insertAllRows.sql
-- Call on stored procedure to update the inserted item's statuses.
call updateItemStatus(1);
call updateItemStatus(2);
call updateItemStatus(3);
call updateItemStatus(4);
call updateItemStatus(5);
call updateItemStatus(6);
