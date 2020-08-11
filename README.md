# seam-carving-web-app
A web app to intelligently resize your photos, without losing meaningful contents from cropping or scaling. 

Access: http://seamcarving.site/

## Demo
![image](https://raw.githubusercontent.com/94ycwang/seam-carving-web-app/master/img/demo.gif)
<br>
<br>
<br>
![image](https://raw.githubusercontent.com/94ycwang/seam-carving-web-app/master/img/util.gif)

## About Seaming Carving
Seam-carving is a content-aware image resizing technique developed by Shai Avidan, of Mitsubishi Electric Research Laboratories (MERL), and Ariel Shamir, of the Interdisciplinary Center and MERL. The image is reduced in size by one pixel of height or width at a time. A vertical seam in an image is a path of pixels connected from the top to the bottom with one pixel in each row; a horizontal seam is a path of pixels connected from the left to the right with one pixel in each column.

![image](https://raw.githubusercontent.com/94ycwang/seam-carving-web-app/master/img/compare.jpg)

Above left is the original 500-by-333 pixel image; above right is the result after removing 250 vertical seams, resulting in a 50% narrower image. Unlike standard content-agnostic resizing techniques (such as cropping and scaling), seam carving preserves the most interest features (aspect ratio, set of objects present, etc.) of the image.

## Seam Carving Algorithm
The following steps describe the process of seam carving.

- Step 1 - Energy calculation:
The energy of each pixel is a measure of the importance of each pixel- the higher the energy, the less likely that the pixel will be included as part of a seam to remove. The energy is calculated by gradient magnitudes here. The energy is high (white) for pixels in the image where there is a rapid color gradient.

![image](https://raw.githubusercontent.com/94ycwang/seam-carving-web-app/master/img/energy.png)

- Step 2 - Seam identification:
A vertical (or) horizontal seam of minimum total energy is calculated via the dynamic programming approach similar to the classic shortest path problem in an edge-weighted digraph.The weight is the energy at each pixel. The purpose of this step is to find the shortest path from any of the W pixels in the top row (left column) to any of the W pixels in the bottom row (right column).
![image](https://raw.githubusercontent.com/94ycwang/seam-carving-web-app/master/img/seams.jpg)
- Step 3 - Seam removal:
The final step is to remove from the image all of the pixels along the seam.

- Step 2 and Step 3 will be repeated until desired amount of seams are removed.

