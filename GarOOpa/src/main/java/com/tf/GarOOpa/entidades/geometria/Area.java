package com.tf.entidades.geometria;
public class Area {

private Ponto pSupEsq, pInfDir;

public Area(Ponto pSupEsq, Ponto pInfDir) {

if ((pSupEsq.getX() >= pInfDir.getX()) || (pSupEsq.getY() <= pInfDir.getY())) {

    throw new IllegalArgumentException("O retangulo deve ser definido pela diagonal principal");

} else {

this.pSupEsq = pSupEsq;

this.pInfDir = pInfDir;

}

}

public Ponto getPSupEsq() {

return pSupEsq;

}

public Ponto getPInfDir() {

return pInfDir;

}

private static final int INSIDE = 0;
private static final int LEFT   = 1;
private static final int RIGHT  = 2;
private static final int BOTTOM = 4;
private static final int TOP    = 8;

private final int regionCode(double x, double y) {
    int code = x <  pSupEsq.getX()
        ? LEFT
        : x > pInfDir.getX()
            ? RIGHT
            : INSIDE;
         if (y < pInfDir.getY()) code |= BOTTOM;
    else if (y > pSupEsq.getY()) code |= TOP;
    return code;

}

public SituacaoReta classificaAlt (Reta reta) {

    int y0 = reta.getP1().getY();
    int yf = reta.getP2().getY();
    int x0 = reta.getP1().getX();
    int xf = reta.getP2().getX();
    int xMax = pInfDir.getX();
    int xMin = pSupEsq.getX();
    int yMax = pSupEsq.getY();
    int yMin = pInfDir.getY();

    // SE OS DOIS PONTOS ESTAO DENTRO DA RETA JA RETORNA DENTRO
    if(x0<=xMax && x0 >=xMin && xf<=xMax && xf>=xMin && y0<=yMax && y0>=yMin && yf<=yMax && yf>=yMin) {

        return SituacaoReta.TODA_DENTRO;
    // MAS SE NAO ESTIVEREM, ELES SOH PODEM SER INTERSECTA OU FORA
    }   else {

            if(x0<=xMax && x0 >=xMin &&  y0<=yMax && y0>=yMin || xf<=xMax && xf>=xMin && yf<=yMax && yf>=yMin) {

                return SituacaoReta.INTERSECTA;

            }

            return SituacaoReta.TODA_FORA;  

    }




}

public SituacaoReta classifica(Reta reta) {
// TO DO: implementar Cohen e Shuterland
    
    int x1,y1,x2,y2;
    x1 = reta.getP1().getX();
    y1 = reta.getP1().getY();
    x2 = reta.getP2().getX();
    y2 = reta.getP2().getY();
    int c1 = regionCode(reta.getP1().getX(), reta.getP1().getY());
    int c2 = regionCode(reta.getP2().getX(), reta.getP2().getY());

    while (c1 != INSIDE || c2 != INSIDE) {

        if (c1 == 0 && c2 == 0){ 

            return SituacaoReta.TODA_DENTRO;

        } else if (c1 != 0 && c2 != 0) {

            return SituacaoReta.TODA_FORA;

        } else {

            int c0;

            if (c1 != 0) {

                c0 = c1;

            }else {

                c0 = c2;

            }

            int x = 0;
            int y = 0;

            if ((c0 & TOP) == 1) {

                x = x1 + (x2-x1) * (pSupEsq.getY()-y1) / (y2-y1); 
                y = pSupEsq.getY();

            } else if ((c0 & BOTTOM) == 1) {

                x = x1 + (x2 - x1) * (pInfDir.getY() - y1) / (y2 - y1); 
                y = pInfDir.getY(); 

            }else if ((c0 & RIGHT) == 1) {

                y = y1 + (y2 - y1) * (pInfDir.getX() - x1) / (x2 - x1);
                x = pInfDir.getX();

            }else if ((c0 & LEFT) == 1) {

                y = y1 + (y2 - y1) * (pSupEsq.getX() - x1) / (x2 - x1);
                x = pSupEsq.getX();

            }

            if (c0 == c1) {

                x1 = x;
                y1 = y;
                c1 = regionCode(x1, y1);

            }else {

                x2 = x;
                y2 = y;
                c2 = regionCode(x2, y2);

            }

            return SituacaoReta.INTERSECTA;

        }
        
     
    }
    return SituacaoReta.TODA_FORA;

}

    @Override

    public String toString() {

return "Area [pInfDir=" + pInfDir + ", pSupEsq=" + pSupEsq + "]"; 

    } 

}