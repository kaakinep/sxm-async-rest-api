package com.sxm.model;

public enum TransmissionType{

        MANUAL,AUTO;

        public static boolean contains(String s)
        {
            for(TransmissionType transmissionType:values()) {
                if (transmissionType.name().equals(s))
                    return true;
            }
                return false;
        }
}
