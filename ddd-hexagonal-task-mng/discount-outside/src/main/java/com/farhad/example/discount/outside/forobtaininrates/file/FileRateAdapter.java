package com.farhad.example.discount.outside.forobtaininrates.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ListIterator;

import com.farhad.example.discount.application.BreakPointWithRate;
import com.farhad.example.discount.application.ports.driven.ForObtainingRate;


public class FileRateAdapter implements ForObtainingRate {

	private final String rateFileName;

	
	public FileRateAdapter(String rateFileName, String... lines) {
        if ( rateFileName==null || rateFileName.trim().isEmpty() ) {
            throw new IllegalArgumentException("RateFileName must be provided");
        }
        this.rateFileName = rateFileName;	
        if ( (lines!=null) && (lines.length>0) ) {
            System.out.println("Writing to file '"+rateFileName+"'...");
            try {
                Files.write ( Paths.get(rateFileName), Arrays.asList(lines) );
            } catch (IOException e) {
                throw new RuntimeException("An I/O error occurred creating or writing to the file '"+rateFileName+"'",e);
            }
        }		
	}


	@Override
	public ListIterator<BreakPointWithRate> getDescendingBreakPointIterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getDescendingBreakPointIterator'");
	}
	
}
