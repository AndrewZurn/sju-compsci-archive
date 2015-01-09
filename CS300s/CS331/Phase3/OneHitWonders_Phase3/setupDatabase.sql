-- Setup Schema
source ~/Desktop/OneHitWonders_Phase3/eSaintCreateScript.sql

-- Setup Events
source ~/Desktop/OneHitWonders_Phase3/scripts/Item_Status_Event.sql

-- Setup Stored Procedures
source ~/Desktop/OneHitWonders_Phase3/Phase3/scripts/itemCurrentOrWinningBidProc.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/updateItemStatusProc.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/Item_Event_Procedure.sql

-- Setup Stored Functions
source ~/Desktop/OneHitWonders_Phase3/scripts/insertAuctionBidFunc.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/getSellerFeedbackFunc.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/getBuyerFeedbackFunc.sql

-- Setup Triggers
source ~/Desktop/OneHitWonders_Phase3/scripts/updateCurrentBidTrigger.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/updateWinnerIdTrigger.sql

-- Setup Views
source ~/Desktop/OneHitWonders_Phase3/scripts/viewCommissionReport.sql
source ~/Desktop/OneHitWonders_Phase3/scripts/viewSalesReport.sql

-- Setup Mock Data
source ~/Desktop/OneHitWonders_Phase3/scripts/insertScripts/insertAllRows.sql 
