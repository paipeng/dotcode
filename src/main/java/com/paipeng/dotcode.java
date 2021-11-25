package com.paipeng;

import com.dynamsoft.dbr.*;

public class dotcode {
    public static void main(String[] args) throws BarcodeReaderException {
        doDecode(args[0]);
    }

    private static void doDecode(String decodeFilePath) throws BarcodeReaderException {
        System.out.println("doDecode: " + decodeFilePath);
        BarcodeReader reader = new BarcodeReader();

        reader.initLicense("");

        PublicRuntimeSettings runtimeSettings = reader.getRuntimeSettings();
        runtimeSettings.barcodeFormatIds = EnumBarcodeFormat.BF_NULL;
        runtimeSettings.barcodeFormatIds_2 = EnumBarcodeFormat_2.BF2_DOTCODE;
        runtimeSettings.expectedBarcodesCount = 32;
        reader.updateRuntimeSettings(runtimeSettings);


        TextResult[] results;
        try
        {
            results = reader.decodeFile(decodeFilePath, "");
            System.out.println("Total barcodes found: " + results.length);
            for (int iIndex = 0; iIndex < results.length; ++iIndex)
            {
                System.out.println("Barcode " + (iIndex + 1));
                if (results[iIndex].barcodeFormat != 0)
                {
                    System.out.println("    Barcode Format: " + results[iIndex].barcodeFormatString);
                }
                else
                {
                    System.out.println("    Barcode Format: " + results[iIndex].barcodeFormatString_2);
                }
                System.out.println("    Barcode Text: " + results[iIndex].barcodeText);
            }
        }
        catch (BarcodeReaderException exp)
        {
            System.out.println(exp.getMessage());
        }


        reader.destroy();
    }
}
